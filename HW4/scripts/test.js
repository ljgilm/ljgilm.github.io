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
let responseEasy;
let dataEasy;
let rowsEasy;

async function initEasy() {
    responseEasy = await fetch("csv/Easy.csv");
    dataEasy = await responseEasy.text();
    rowsEasy = dataEasy.split("\n");
}

function getEasy() {
    let index1 = getRandomNum(rowsEasy.length-1);
    let index2 = getRandomNum(rowsEasy.length-1);
    let index3 = getRandomNum(rowsEasy.length-1);

    let options = [rowsEasy[index1], rowsEasy[index2], rowsEasy[index3]];
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
let responseMedium;
let dataMedium;
let rowsMedium;

async function initMedium() {
    responseMedium = await fetch("csv/Medium.csv");
    dataMedium = await responseMedium.text();
    rowsMedium = dataMedium.split("\n");
}

function getMedium() {
    let index1 = getRandomNum(rowsMedium.length-1);
    let index2 = getRandomNum(rowsMedium.length-1);
    let index3 = getRandomNum(rowsMedium.length-1);

    let options = [rowsMedium[index1], rowsMedium[index2], rowsMedium[index3]];
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
let responseHard;
let dataHard;
let rowsHard

async function initHard() {
    responseHard = await fetch("csv/Hard.csv");
    dataHard = await responseHard.text();
    rowsHard = dataHard.split("\n");
}

function getHard() {
    let index1 = getRandomNum(rowsHard.length-1);
    let index2 = getRandomNum(rowsHard.length-1);
    let index3 = getRandomNum(rowsHard.length-1);

    let options = [rowsHard[index1], rowsHard[index2], rowsHard[index3]];
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
let responseMovies;
let dataMovies;
let rowsMovies;

async function initMovies() {
    responseMovies = await fetch("csv/Movies.csv");
    dataMovies = await responseMovies.text();
    rowsMovies = dataMovies.split("\n");
}

function getMovies() {
    let index1 = getRandomNum(rowsMovies.length-1);
    let index2 = getRandomNum(rowsMovies.length-1);
    let index3 = getRandomNum(rowsMovies.length-1);

    let options = [rowsMovies[index1], rowsMovies[index2], rowsMovies[index3]];
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
    initEasy();
    initMedium();
    initHard();
    initMovies();
    const canvasViewOnly = window.open("canvas.html");
    if (startBut.style.display === "none") {
        options.style.display = "block";
    } else {
        startBut.style.display = "none";
    }
}



