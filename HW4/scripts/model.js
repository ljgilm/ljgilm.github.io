const canvas = document.getElementById("drawingcanvas");
const context = canvas.getContext("2d");

let isDrawing = false;
let x = 0;
let y = 0;
//const canvasSize = 900;

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

let responseEasy;
let dataEasy;
let rowsEasy;
let optionsEasy;

let responseMedium;
let dataMedium;
let rowsMedium;
let optionsMedium;

let responseHard;
let dataHard;
let rowsHard;
let optionsHard;

let responseMovies;
let dataMovies;
let rowsMovies;
let optionsMovies;

async function initAll() {

    responseEasy = await fetch("csv/Easy.csv");
    dataEasy = await responseEasy.text();
    rowsEasy = dataEasy.split("\n");

    responseMedium = await fetch("csv/Medium.csv");
    dataMedium = await responseMedium.text();
    rowsMedium = dataMedium.split("\n");

    responseHard = await fetch("csv/Hard.csv");
    dataHard = await responseHard.text();
    rowsHard = dataHard.split("\n");

    responseMovies = await fetch("csv/Movies.csv");
    dataMovies = await responseMovies.text();
    rowsMovies = dataMovies.split("\n");

    await getEasy();
    await getMedium();
    await getHard();
    await getMovies();
}

function getEasy() {
    let index1 = getRandomNum(rowsEasy.length - 1);
    let index2 = getRandomNum(rowsEasy.length - 1);
    let index3 = getRandomNum(rowsEasy.length - 1);

    optionsEasy = [rowsEasy[index1], rowsEasy[index2], rowsEasy[index3]];

    printEasyOptions(`${optionsEasy[0]}`, `${optionsEasy[1]}`, `${optionsEasy[2]}`);

    console.log("Easy: " + optionsEasy);
}

function getMedium() {
    let index1 = getRandomNum(rowsMedium.length - 1);
    let index2 = getRandomNum(rowsMedium.length - 1);
    let index3 = getRandomNum(rowsMedium.length - 1);

    optionsMedium = [rowsMedium[index1], rowsMedium[index2], rowsMedium[index3]];

    printMediumOptions(`${optionsMedium[0]}`, `${optionsMedium[1]}`, `${optionsMedium[2]}`);

    console.log("Medium: " + optionsMedium);
}

function getHard() {
    let index1 = getRandomNum(rowsHard.length - 1);
    let index2 = getRandomNum(rowsHard.length - 1);
    let index3 = getRandomNum(rowsHard.length - 1);

    optionsHard = [rowsHard[index1], rowsHard[index2], rowsHard[index3]];

    printHardOptions(`${optionsHard[0]}`, `${optionsHard[1]}`, `${optionsHard[2]}`);

    console.log("Hard: " + optionsHard);
}

function getMovies() {
    let index1 = getRandomNum(rowsMovies.length - 1);
    let index2 = getRandomNum(rowsMovies.length - 1);
    let index3 = getRandomNum(rowsMovies.length - 1);

    optionsMovies = [rowsMovies[index1], rowsMovies[index2], rowsMovies[index3]];

    printMoviesOptions(`${optionsMovies[0]}`, `${optionsMovies[1]}`, `${optionsMovies[2]}`);

    console.log("Movies: " + optionsMovies);
}

let timerDone = false;
function displayChoice(choice) {
    
    return function () {
        hideOptions();
        timeLeft = startTimeAmount;
        timerDone = true;
        printChoice(`${choice}`);
        timerFunc();
        accessCanvas();
        activateFadeToBlack();
        
    }
}


var reqID;
function timerFunc() {
    if (timerDone) {
        const now = Date.now();
        displayTimer();
        if (now - then > 1000) {
            (timeLeft - 1 < 0) ? console.log("Timer Ended") : timeLeft--;
            displayTimer();
            then = Date.now();
        }
        reqID = requestAnimationFrame(timerFunc);
        //console.log("ReqID: " + reqID);

        //console.log("Before: " + timeLeft);
        if (timeLeft == 5) {
            turnBlack();
        }
        if (timeLeft <= 0) {
            cancelAnimationFrame(reqID);
            disableCanvas();
            displayTimer();
            turnOnNextButton();
            timerDone = false;
        }
        //console.log("After: " + timeLeft);
    }
}

function nextTurn() {
    clearCanvas();
    //context.clearRect(0,0, canvas.width, canvas.height);
    console.log("NEXTTTTTTTTTTTTTTTTTTTTTTTT TURN")
    showOptionsHideNext();
    clearChoice();
    removeFading();
}

function getRandomNum(length) {
    return Math.floor(Math.random() * length);
}

function startGame() {
    initAll();
    disableCanvas();
    //openCanvasCopyTab();
    hideStartButton();
    showGame();

}



