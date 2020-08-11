const path = require("path");
const express = require("express");

const app = express();


const buildPath = path.join(__dirname, "dist");
app.use(express.static(buildPath));

app.use("/*", (req, res) => {
    res.sendFile(path.join(buildPath, "index.html"))
});

const PORT = process.env.DEFAULT_SERVICE_PORT || 8080;
app.listen(PORT, function(err) {
    console.log("UI Server started...");
});