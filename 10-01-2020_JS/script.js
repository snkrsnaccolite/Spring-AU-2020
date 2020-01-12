"use strict";

// Validation

const signup = () => {
    let user = document.getElementById("user").value;
    let passwd = document.getElementById("passwd").value;
    let cpasswd = document.getElementById("cpasswd").value;

    if (!user || !passwd || !cpasswd) return window.alert("Please enter your credentials.");

    if (!/^[a-z0-9]+$/i.test(user))
        return window.alert("Username should only contain alphanumeric characters.");

    if (!/^.*(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!#$%&@? "])(?=.*abc).*$/.test(passwd))
        return window.alert("Password must have one lowercase letter, one uppercase letter, one special character (!#$%&@? ), one number, must contain \"abc\" and must be longer than 8 characters.");

    if (passwd !== cpasswd) return window.alert("Password doesn't match.");

    console.log({ user, passwd, });
};


// Filter

let users = [
    "k3rn31p4nic",
    "SaffronPants",
    "DSX",
    "PepperKick",
    "Midnight",
    "Josh43",
    "traction13",
];
const usersDiv = document.getElementById("users");

const updateUsers = (users) => usersDiv.innerText = users.join("\n");

const filter = (element) => {
    let filteredUsers = element.value
    ? users.filter(u => u.toLowerCase().includes(element.value.toLowerCase()))
    : users;

    updateUsers(filteredUsers);
};

const sort = () => {
    let filteredUsers = usersDiv.innerText.split("\n");
    let sortedUsers = filteredUsers.sort();
    updateUsers(sortedUsers);
};
