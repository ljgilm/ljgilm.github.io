function printEasyOptions(easyOp0, easyOp1, easyOp2) {
    const easy0 = document.getElementById("easy0");
    const easy1 = document.getElementById("easy1");
    const easy2 = document.getElementById("easy2");
    easy0.innerHTML = easyOp0;
    easy1.innerHTML = easyOp1;
    easy2.innerHTML = easyOp2;
}

function printMediumOptions(mediumOp0, mediumOp1, mediumOp2) {
    const medium0 = document.getElementById("medium0");
    const medium1 = document.getElementById("medium1");
    const medium2 = document.getElementById("medium2");
    medium0.innerHTML = mediumOp0;
    medium1.innerHTML = mediumOp1;
    medium2.innerHTML = mediumOp2;
}

function printHardOptions(hardOp0, hardOp1, hardOp2) {
    const hard0 = document.getElementById("hard0");
    const hard1 = document.getElementById("hard1");
    const hard2 = document.getElementById("hard2");
    hard0.innerHTML = hardOp0;
    hard1.innerHTML = hardOp1;
    hard2.innerHTML = hardOp2;
}

function printMoviesOptions(moviesOp0, moviesOp1, moviesOp2) {
    const movies0 = document.getElementById("movies0");
    const movies1 = document.getElementById("movies1");
    const movies2 = document.getElementById("movies2");
    movies0.innerHTML = moviesOp0;
    movies1.innerHTML = moviesOp1;
    movies2.innerHTML = moviesOp2;
}

function printChoice(choice) {
    //let whatAmIDrawing = document.getElementById("whatAmIDrawing");
    //whatAmIDrawing.innerHTML = `${choice}`;
    //console.log("CHOOOOOOSE: " + choice);
    console.log(`You choice: ${choice} \nYou have 30 seconds to draw! However, the screen will be fading to black so draw fast!`);
}

function clearChoice() {
    whatAmIDrawing.innerHTML = ``;
}

function activateFadeToBlack() {
    const drawingcanvas = document.getElementById("drawingcanvas");
    drawingcanvas.className = "canvas"; 
}

function removeFading() {
    const drawingcanvas = document.getElementById("drawingcanvas");
    drawingcanvas.className = ""; 
}

function turnBlack() {
    const drawingcanvas = document.getElementById("drawingcanvas");
    drawingcanvas.className = "canvasBlack"; 
}

function turnBlackOff() {
    const drawingcanvas = document.getElementById("drawingcanvas");
    drawingcanvas.className = ""; 
}

function hideOptions() {
    const options = document.getElementById("options");
    
    /*if (options.style.display === "none") {
        options.style.display = "inline";
        console.log("show options");
    } else {
        options.style.display = "none";
        console.log("hide options");
    }*/

    options.style.display="none";

    const nextTurnBut = document.getElementById("nextTurnBut");
    nextTurnBut.style.display = "none";
}

function displayTimer() {
    const timer = document.getElementById("timer");
    timer.innerHTML = `${timeLeft}`;  
}

function hideTimer() {
    const timer = document.getElementById("timer");
    timer.innerHTML = ``;  
}

function turnOnNextButton() {
    const nextTurnBut = document.getElementById("nextTurnBut");
    const options = document.getElementById("options");

    options.style.display = "none";
    nextTurnBut.style.display = "block"; 
    hideTimer();

    /*if (nextTurnBut.style.display === "none") {
        nextTurnBut.style.display = "inline";
        console.log("TURN NEXT BUTTON ON");
    } else {
        nextTurnBut.style.display = "none";
        console.log("TURN NEXT BUTTON OFF");
    }*/
}

function showOptionsHideNext() {
    const options = document.getElementById("options");
    const nextTurnBut = document.getElementById("nextTurnBut");

    options.style.display = "inline";
    nextTurnBut.style.display = "none";

    /*if (options.style.display === "none") {
        options.style.display = "inline";
        console.log("shop options hide next: show")
    } else {
        options.style.display = "none";
        console.log("shop options hide next: hide")
    }

    if (nextTurnBut.style.display === "none") {
        nextTurnBut.style.display = "block";
    } else {
        nextTurnBut.style.display = "none";
    }*/
}

function disableCanvas() {
    const canvas = document.getElementById("drawingcanvas");
    canvas.removeEventListener("mousemove", movingCursor);
    canvas.removeEventListener("mousedown", mouseDown);
    canvas.removeEventListener("mouseup", mouseUp);
}

function accessCanvas() {
    const canvas = document.getElementById("drawingcanvas");
    canvas.addEventListener("mousemove", movingCursor);
    canvas.addEventListener("mousedown", mouseDown);
    canvas.addEventListener("mouseup", mouseUp);
}

function openCanvasCopyTab(){
    const canvasViewOnly = window.open("canvas.html");
}

function hideStartButton() {
    const startBut = document.getElementById("startBut");
    if (startBut.style.display === "none") {
        startBut.style.display = "inline";
    } else {
        startBut.style.display = "none";
    }
}

function showGame() {
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