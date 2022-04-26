import * as http from './http.js' //Import http functions
import * as view from './view.js';

const GET_MOVIE = `https://k2maan-moviehut.herokuapp.com/api/random`;

//const canvas = document.getElementById("drawingcanvas");
//const context = canvas.getContext("2d");

let isDrawing = false;
let x = 0;
let y = 0;
//const canvasSize = 900;

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

let timerDone = false;
var reqID;

window.drawing = () => {
    context.beginPath();
    context.moveTo(0, 0);
    context.lineTo(300, 150);
    context.stroke();
}

window.movingCursor = (event) => {
    if (isDrawing === true) {
        drawLine(context, x, y, event.offsetX, event.offsetY);
        x = event.offsetX;
        y = event.offsetY;
        console.log(`X: ${x} Y: ${y}`);

    }
}

window.mouseDown = (event) => {
    console.log("MOUSE DOOOOWN");
    x = event.offsetX;
    y = event.offsetY;
    isDrawing = true;
}

window.mouseUp = (event) => {
    if (isDrawing === true) {
        drawLine(context, x, y, event.offsetX, event.offsetY);
        x = 0;
        y = 0;
        isDrawing = false;
    } 
}

window.drawLine = (context, x1, y1, x2, y2) => {
    context.beginPath();
    context.strokeStyle = 'black';
    context.lineWidth = 1;
    context.moveTo(x1, y1);
    context.lineTo(x2, y2);
    context.stroke();
    context.closePath();
}

window.invokeMovie = async () => { 
    const json = await http.sendGETRequest(GET_MOVIE); //GET Request for trivia data
    console.log("FETCHING MOVIE:" + json.name); 
    return json;
}

window.initAll = async function () {
    responseEasy = await fetch("csv/Easy.csv");
    dataEasy = await responseEasy.text();
    rowsEasy = dataEasy.split("\n");

    responseMedium = await fetch("csv/Medium.csv");
    dataMedium = await responseMedium.text();
    rowsMedium = dataMedium.split("\n");

    responseHard = await fetch("csv/Hard.csv");
    dataHard = await responseHard.text();
    rowsHard = dataHard.split("\n");

    await getEasy();
    await getMedium();
    await getHard();
    await getMovies();
}

window.getEasy = async function () {
    let index1 = getRandomNum(rowsEasy.length - 1);
    let index2 = getRandomNum(rowsEasy.length - 1);
    let index3 = getRandomNum(rowsEasy.length - 1);

    optionsEasy = [rowsEasy[index1], rowsEasy[index2], rowsEasy[index3]];

    printEasyOptions(`${optionsEasy[0]}`, `${optionsEasy[1]}`, `${optionsEasy[2]}`);

    console.log("Easy: " + optionsEasy);
}

window.getMedium = async function () {
    let index1 = getRandomNum(rowsMedium.length - 1);
    let index2 = getRandomNum(rowsMedium.length - 1);
    let index3 = getRandomNum(rowsMedium.length - 1);

    optionsMedium = [rowsMedium[index1], rowsMedium[index2], rowsMedium[index3]];

    printMediumOptions(`${optionsMedium[0]}`, `${optionsMedium[1]}`, `${optionsMedium[2]}`);

    console.log("Medium: " + optionsMedium);
}

window.getHard = async function () {
    let index1 = getRandomNum(rowsHard.length - 1);
    let index2 = getRandomNum(rowsHard.length - 1);
    let index3 = getRandomNum(rowsHard.length - 1);

    optionsHard = [rowsHard[index1], rowsHard[index2], rowsHard[index3]];

    printHardOptions(`${optionsHard[0]}`, `${optionsHard[1]}`, `${optionsHard[2]}`);

    console.log("Hard: " + optionsHard);
}

window.getMovies = async function () {
    let movie1 = await invokeMovie();
    let movie2 = await invokeMovie();
    let movie3 = await invokeMovie();

    optionsMovies = await [movie1.name, movie2.name, movie3.name];

    await printMoviesOptions(`${optionsMovies[0]}`, `${optionsMovies[1]}`, `${optionsMovies[2]}`);

    await console.log("Movies: " + optionsMovies);
}

window.reloadMovies = async function () {
    let movie1 = await invokeMovie();
    let movie2 = await invokeMovie();
    let movie3 = await invokeMovie();

    optionsMovies = await [movie1.name, movie2.name, movie3.name];

    return optionsMovies;
}

window.displayReloadMovies = async function () {
    await printMoviesOptions(`${optionsMovies[0]}`, `${optionsMovies[1]}`, `${optionsMovies[2]}`);
    await console.log("Movies: " + optionsMovies);
}

window.displayChoice = function (choice)  {
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

window.timerFunc = function () {
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

window.nextTurn = function () {
    clearCanvas();
    getMovies();
    //context.clearRect(0,0, canvas.width, canvas.height);
    console.log("NEXTTTTTTTTTTTTTTTTTTTTTTTT TURN")
    showOptionsHideNext();
    clearChoice();
    removeFading();
}

window.getRandomNum = function(length) {
    return Math.floor(Math.random() * length);
}

window.startGame = function () {
    initAll();
    disableCanvas();
    //openCanvasCopyTab();
    //hideStartButton();
    showGame();
}

window.openGame = function () {
    view.StartScene();
    invokeMovie();
    intitControls();
}


window.addEventListener('load', openGame); //When window loads execute start

// CONTROLLER - Event Listeners
    window.intitControls = function () {
        const startBut = document.getElementById("startBut");
        startBut.addEventListener("click", letsPlay);

    }

    window.clickEasyOption = function () {
        getEasy();
        const easy0 = document.getElementById("easy0");
        const easy1 = document.getElementById("easy1");
        const easy2 = document.getElementById("easy2");

        easy0.addEventListener("click", displayChoice(optionsEasy[0]));
        easy1.addEventListener("click", displayChoice(optionsEasy[1]));
        easy2.addEventListener("click", displayChoice(optionsEasy[2]));
    }

    window.clickMediumOption = function () {
        getMedium();
        const medium0 = document.getElementById("medium0");
        const medium1 = document.getElementById("medium1");
        const medium2 = document.getElementById("medium2");

        medium0.addEventListener("click", displayChoice(optionsMedium[0]));
        medium1.addEventListener("click", displayChoice(optionsMedium[1]));
        medium2.addEventListener("click", displayChoice(optionsMedium[2]));
    }

    window.clickHardOption = function () {
        getHard();
        const hard0 = document.getElementById("hard0");
        const hard1 = document.getElementById("hard1");
        const hard2 = document.getElementById("hard2");

        hard0.addEventListener("click", displayChoice(optionsHard[0]));
        hard1.addEventListener("click", displayChoice(optionsHard[1]));
        hard2.addEventListener("click", displayChoice(optionsHard[2]));
    }

    window.clickMoviesOption = function () {

        reloadMovies();

        const movies0 = document.getElementById("movies0");
        const movies1 = document.getElementById("movies1");
        const movies2 = document.getElementById("movies2");

        movies0.addEventListener("click", displayChoice(optionsMovies[0]));
        movies1.addEventListener("click", displayChoice(optionsMovies[1]));
        movies2.addEventListener("click", displayChoice(optionsMovies[2]));

        var myModalEl = document.getElementById('moviesButMod')
        myModalEl.addEventListener('hidden.bs.modal', function (event) {displayReloadMovies()});
    }

    window.nextPersonTurn = function () {
        nextTurn();
        document.body.scrollTop = 1000;
        console.log("nectTurn invoked");
    }

    window.letsPlay = function () {

        view.ShowGameScreen();

        window.canvas = document.getElementById("drawingcanvas");
        window.context = canvas.getContext("2d");

        const easyBut = document.getElementById("easyBut");
        easyBut.addEventListener("click", clickEasyOption);

        const mediumBut = document.getElementById("mediumBut");
        mediumBut.addEventListener("click", clickMediumOption);

        const hardBut = document.getElementById("hardBut");
        hardBut.addEventListener("click", clickHardOption);

        const moviesBut = document.getElementById("moviesBut");
        moviesBut.addEventListener("click", clickMoviesOption);

        const nextTurnBut = document.getElementById("nextTurnBut");
        nextTurnBut.addEventListener("click", nextPersonTurn);

        startGame();

        //var canvas = document.getElementById('drawingcanvas');
        //var heightRatio = 0.75;
        //canvas.height = canvas.width * heightRatio;
    }

    window.clearCanvas = function () {
        const canvas = document.getElementById("drawingcanvas");
        const context = canvas.getContext("2d");
        context.clearRect(0,0, canvas.width, canvas.height);
    }


// Controls Visuals
    window.printEasyOptions = function (easyOp0, easyOp1, easyOp2) {
        const easy0 = document.getElementById("easy0");
        const easy1 = document.getElementById("easy1");
        const easy2 = document.getElementById("easy2");
        easy0.innerHTML = easyOp0;
        easy1.innerHTML = easyOp1;
        easy2.innerHTML = easyOp2;
    }

    window.printMediumOptions = function (mediumOp0, mediumOp1, mediumOp2) {
        const medium0 = document.getElementById("medium0");
        const medium1 = document.getElementById("medium1");
        const medium2 = document.getElementById("medium2");
        medium0.innerHTML = mediumOp0;
        medium1.innerHTML = mediumOp1;
        medium2.innerHTML = mediumOp2;
    }

    window.printHardOptions = function (hardOp0, hardOp1, hardOp2) {
        const hard0 = document.getElementById("hard0");
        const hard1 = document.getElementById("hard1");
        const hard2 = document.getElementById("hard2");
        hard0.innerHTML = hardOp0;
        hard1.innerHTML = hardOp1;
        hard2.innerHTML = hardOp2;
    }

    window.printMoviesOptions = function (moviesOp0, moviesOp1, moviesOp2) {
        const movies0 = document.getElementById("movies0");
        const movies1 = document.getElementById("movies1");
        const movies2 = document.getElementById("movies2");
        movies0.innerHTML = moviesOp0;
        movies1.innerHTML = moviesOp1;
        movies2.innerHTML = moviesOp2;
    }

    window.printChoice = function (choice) {
        console.log(`You choice: ${choice} \nYou have 30 seconds to draw! However, the screen will be fading to black so draw fast!`);
    }

    window.clearChoice = function () {
        whatAmIDrawing.innerHTML = ``;
    }

    window.activateFadeToBlack = function () {
        const drawingcanvas = document.getElementById("drawingcanvas");
        drawingcanvas.className = "canvas"; 
    }

    window.removeFading = function () {
        const drawingcanvas = document.getElementById("drawingcanvas");
        drawingcanvas.className = ""; 
    }

    window.turnBlack = function () {
        const drawingcanvas = document.getElementById("drawingcanvas");
        drawingcanvas.className = "canvasBlack"; 
    }

    window.turnBlackOff = function () {
        const drawingcanvas = document.getElementById("drawingcanvas");
        drawingcanvas.className = ""; 
    }

    window.hideOptions = function () {
        const options = document.getElementById("options");

        options.style.display="none";

        const nextTurnBut = document.getElementById("nextTurnBut");
        nextTurnBut.style.display = "none";
    }

    window.displayTimer = function () {
        const timer = document.getElementById("timer");
        timer.innerHTML = `${timeLeft}`;  
    }

    window.hideTimer = function () {
        const timer = document.getElementById("timer");
        timer.innerHTML = ``;  
    }

    window.turnOnNextButton = function () {
        const nextTurnBut = document.getElementById("nextTurnBut");
        const options = document.getElementById("options");

        options.style.display = "none";
        nextTurnBut.style.display = "block"; 
        hideTimer();
    }

    window.showOptionsHideNext = function () {
        const options = document.getElementById("options");
        const nextTurnBut = document.getElementById("nextTurnBut");

        options.style.display = "inline";
        nextTurnBut.style.display = "none";
    }

    window.disableCanvas = function () {
        const canvas = document.getElementById("drawingcanvas");
        canvas.removeEventListener("mousemove", movingCursor);
        canvas.removeEventListener("mousedown", mouseDown);
        canvas.removeEventListener("mouseup", mouseUp);
    }

    window.accessCanvas = function () {
        const canvas = document.getElementById("drawingcanvas");
        canvas.addEventListener("mousemove", movingCursor);
        canvas.addEventListener("mousedown", mouseDown);
        canvas.addEventListener("mouseup", mouseUp);
    }

    window.openCanvasCopyTab = function (){
        const canvasViewOnly = window.open("canvas.html");
    }

    window.hideStartButton = function () {
        const startBut = document.getElementById("startBut");
        if (startBut.style.display === "none") {
            startBut.style.display = "inline";
        } else {
            startBut.style.display = "none";
        }
    }

    window.showGame = function () {
        const game = document.getElementById("game");
        const startDiv = document.getElementById("startDiv");
        const monkey = document.getElementById("monkey");
        const titleStart = document.getElementById("titleStart");

        if (game.style.display === "none") {
            game.style.display = "block";
            console.log("Click Start Game!");
            game.className = "row d-flex justify-content-center m-2"
        } else {
            game.style.display = "none";
        }

        if (startDiv.style.display === "none") {
            startDiv.style.display = "block";
        } else {
            startDiv.style.display = "none";
            startDiv.remove();
        }

        if (monkey.style.display === "none") {
            monkey.style.display = "block";
        } else {
            monkey.style.display = "none";
        }

        if (titleStart.style.display === "none") {
            titleStart.style.display = "block";
        } else {
            titleStart.style.display = "none";
        }
    }
