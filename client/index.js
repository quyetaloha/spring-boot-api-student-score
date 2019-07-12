var express = require("express");

var app = express();


app.listen(3000);
var path = require("path");
app.use("/", express.static(__dirname + '/views'));
app.get('/login', function (req, res) {
    res.sendFile(path.join(__dirname + '/views/login.html'));
});
app.get('/user-list', function (req, res) {
    res.sendFile(path.join(__dirname + '/views/user-list.html'));
});
app.get('/subject-list', function (req, res) {
    res.sendFile(path.join(__dirname + '/views/subject-list.html'));
});
app.get('/insert', function (req, res) {
    res.sendFile(path.join(__dirname + '/views/insert.html'));
});
