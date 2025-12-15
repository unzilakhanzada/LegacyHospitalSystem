appointments = []
admin_password = "admin123"  # Hard-coded secret

def menu():
    print("1 Add Appointment")
    print("2 View Appointments")
    print("3 Search Appointment")
    print("4 Admin Panel")
    print("5 Exit")

choice = 0

while choice != 5:
    menu()
    choice = int(input("Enter choice: "))

    if choice == 1:
        name = input("Patient Name: ")
        date = input("Date: ")
        appointments.append(name + " - " + date)
        print("Appointment added")

    if choice == 2:
        for a in appointments:
            print(a)

    if choice == 3:
        search = input("Search name: ")
        found = False
        for a in appointments:
            if search in a:
                found = True
        if found == True:
            print("Appointment found")
        else:
            print("Appointment not found")

    if choice == 4:
        pwd = input("Enter admin password: ")
        if pwd == admin_password:
            print("Admin access granted")
            print("Total appointments:", len(appointments))
        else:
            print("Wrong password")

    if choice > 5:
        print("Invalid choice")
