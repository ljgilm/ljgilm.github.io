const canvas = document.getElementById("drawingcanvas");
// manage the context to actually draw graphics into it for 2D graphics
const context = canvas.getContext("2d");
//https://random-word-api.herokuapp.com/word?number=10

//fetch('https://random-word-form.herokuapp.com/random/adjective')
//.then(response => response.json())
//.then(data => console.log(data));

let isDrawing = false;
let x = 0;
let y = 0;
const canvasSize = 400;

const drawing = () => {
    context.beginPath();
    context.moveTo(0, 0);
    context.lineTo(300, 150);
    context.stroke();
}

const movingCursor = (event) => {
    if (isDrawing === true) {
        drawLine(context, x, y, event.offsetX, event.offsetY);
        x = event.offsetX;
        y = event.offsetY;
        console.log(`X: ${x} Y: ${y}`);

    }
}

const mouseDown = (event) => {
    x = event.offsetX;
    y = event.offsetY;
    isDrawing = true;
}

const mouseUp = (event) => {
    if (isDrawing === true) {
        drawLine(context, x, y, event.offsetX, event.offsetY);
        x = 0;
        y = 0;
        isDrawing = false;
    }
}

function drawLine(context, x1, y1, x2, y2) {
    context.beginPath();
    context.strokeStyle = 'black';
    context.lineWidth = 1;
    context.moveTo(x1, y1);
    context.lineTo(x2, y2);
    context.stroke();
    context.closePath();
}

const startTimeAmount = 30;
let timeLeft = startTimeAmount;
let gameover = false;

let then = Date.now();
const timer = document.getElementById("timer");

const easyBut = document.getElementById("easyBut");
easyBut.addEventListener("click", getEasy);

async function getEasy() {
    const response = await fetch("csv/Easy.csv");
    const data = await response.text();
    const rows = data.split("\n");
    let index1 = getRandomNum(rows.length-1);
    let index2 = getRandomNum(rows.length-1);
    let index3 = getRandomNum(rows.length-1);

    let options = [rows[index1], rows[index2], rows[index3]];
    console.log(options);
    const easy0 = document.getElementById("easy0");
    easy0.innerHTML = `${options[0]}`;

    const easy1 = document.getElementById("easy1");
    easy1.innerHTML =`${options[1]}`;

    const easy2 = document.getElementById("easy2");
    easy2.innerHTML =`${options[2]}`;

    easy0.addEventListener("click", displayChoice(options[0]));
    easy1.addEventListener("click", displayChoice(options[1]));
    easy2.addEventListener("click", displayChoice(options[2])); 
}

const mediumBut = document.getElementById("mediumBut");
mediumBut.addEventListener("click", getMedium);

async function getMedium() {
    const response = await fetch("csv/Medium.csv");
    const data = await response.text();
    const rows = data.split("\n");
    let index1 = getRandomNum(rows.length-1);
    let index2 = getRandomNum(rows.length-1);
    let index3 = getRandomNum(rows.length-1);

    let options = [rows[index1], rows[index2], rows[index3]];
    console.log(options);
    const medium0 = document.getElementById("medium0");
    medium0.innerHTML = `${options[0]}`;

    const medium1 = document.getElementById("medium1");
    medium1.innerHTML =`${options[1]}`;

    const medium2 = document.getElementById("medium2");
    medium2.innerHTML =`${options[2]}`;

    medium0.addEventListener("click", displayChoice(options[0]));
    medium1.addEventListener("click", displayChoice(options[1]));
    medium2.addEventListener("click", displayChoice(options[2])); 
}

const hardBut = document.getElementById("hardBut");
hardBut.addEventListener("click", getHard);

async function getHard() {
    const response = await fetch("csv/Hard.csv");
    const data = await response.text();
    const rows = data.split("\n");
    let index1 = getRandomNum(rows.length-1);
    let index2 = getRandomNum(rows.length-1);
    let index3 = getRandomNum(rows.length-1);

    let options = [rows[index1], rows[index2], rows[index3]];
    console.log(options);
    const hard0 = document.getElementById("hard0");
    hard0.innerHTML = `${options[0]}`;

    const hard1 = document.getElementById("hard1");
    hard1.innerHTML =`${options[1]}`;

    const hard2 = document.getElementById("hard2");
    hard2.innerHTML =`${options[2]}`;

    hard0.addEventListener("click", displayChoice(options[0]));
    hard1.addEventListener("click", displayChoice(options[1]));
    hard2.addEventListener("click", displayChoice(options[2])); 
}

const moviesBut = document.getElementById("moviesBut");
moviesBut.addEventListener("click", getMovies);

async function getMovies() {
    const response = await fetch("csv/Movies.csv");
    const data = await response.text();
    const rows = data.split("\n");
    let index1 = getRandomNum(rows.length-1);
    let index2 = getRandomNum(rows.length-1);
    let index3 = getRandomNum(rows.length-1);

    let options = [rows[index1], rows[index2], rows[index3]];
    console.log(options);
    const movies0 = document.getElementById("movies0");
    movies0.innerHTML = `${options[0]}`;

    const movies1 = document.getElementById("movies1");
    movies1.innerHTML =`${options[1]}`;

    const movies2 = document.getElementById("movies2");
    movies2.innerHTML =`${options[2]}`;

    movies0.addEventListener("click", displayChoice(options[0]));
    movies1.addEventListener("click", displayChoice(options[1]));
    movies2.addEventListener("click", displayChoice(options[2])); 
}

const options = document.getElementById("options");
const nextTurnBut = document.getElementById("nextTurnBut");
nextTurnBut.addEventListener("click", nextTurn);
const drawingcanvas = document.getElementById("drawingcanvas");
let whatAmIDrawing = document.getElementById("whatAmIDrawing");

function displayChoice(choice) {
    return function() {
        whatAmIDrawing.innerHTML = `${choice}`;
        console.log("CHOOOOOOSE: " + choice);

        timeLeft = startTimeAmount;
        timerFunc();
        accessCanvas();
        drawingcanvas.className = "canvas"; 

        if (options.style.display === "none") {
            options.style.display = "block";
        } else {
            options.style.display = "none";
        }
    }
}

var reqID;
let isEndofTimer = false;

function timerFunc() {
    const now = Date.now();
    timer.innerHTML = `${timeLeft}`;    
    if (now - then > 1000) {
        (timeLeft-1 < 0) ? console.log("Timer Ended"): timeLeft--;
        timer.innerHTML = `${timeLeft}`;
        then = Date.now();
    }
    reqID = requestAnimationFrame(timerFunc);
    console.log("ReqID: " + reqID);

    if( timeLeft <= 0) {
        cancelAnimationFrame(reqID);
        disableCanvas();
        timer.innerHTML = ``;
        if (nextTurnBut.style.display === "none") {
            nextTurnBut.style.display = "block";
        } else {
            nextTurnBut.style.display = "none";
        }
    }
}

function nextTurn() {
    whatAmIDrawing.innerHTML = ``;
    context.clearRect(0, 0, canvas.width, canvas.height);
    if (options.style.display === "none") {
        options.style.display = "block";
    } else {
        options.style.display = "none";
    }
    if (nextTurnBut.style.display === "none") {
        nextTurnBut.style.display = "block";
    } else {
        nextTurnBut.style.display = "none";
    }
    drawingcanvas.className = ""; 
}

function accessCanvas() {
    canvas.addEventListener("mousemove", movingCursor);
    canvas.addEventListener("mousedown", mouseDown);
    canvas.addEventListener("mouseup", mouseUp);
}

function disableCanvas() {
    canvas.removeEventListener("mousemove", movingCursor);
    canvas.removeEventListener("mousedown", mouseDown);
    canvas.removeEventListener("mouseup", mouseUp);
}


function getRandomNum(length) {
    return Math.floor(Math.random() * length);
}

const startBut = document.getElementById("startBut");
startBut.addEventListener("click", startGame);

function startGame() {
    const canvasViewOnly = window.open("canvas.html");
    if (startBut.style.display === "none") {
        options.style.display = "block";
    } else {
        startBut.style.display = "none";
    }
}



