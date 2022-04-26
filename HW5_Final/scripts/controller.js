//intitControls();
/*
function intitControls() {

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

    const startBut = document.getElementById("startBut");
    startBut.addEventListener("click", letsPlay);


}

function clickEasyOption() {
    getEasy();
    const easy0 = document.getElementById("easy0");
    const easy1 = document.getElementById("easy1");
    const easy2 = document.getElementById("easy2");

    easy0.addEventListener("click", displayChoice(optionsEasy[0]));
    easy1.addEventListener("click", displayChoice(optionsEasy[1]));
    easy2.addEventListener("click", displayChoice(optionsEasy[2]));
}

function clickMediumOption() {
    getMedium();
    const medium0 = document.getElementById("medium0");
    const medium1 = document.getElementById("medium1");
    const medium2 = document.getElementById("medium2");

    medium0.addEventListener("click", displayChoice(optionsMedium[0]));
    medium1.addEventListener("click", displayChoice(optionsMedium[1]));
    medium2.addEventListener("click", displayChoice(optionsMedium[2]));
}

function clickHardOption() {
    getHard();
    const hard0 = document.getElementById("hard0");
    const hard1 = document.getElementById("hard1");
    const hard2 = document.getElementById("hard2");

    hard0.addEventListener("click", displayChoice(optionsHard[0]));
    hard1.addEventListener("click", displayChoice(optionsHard[1]));
    hard2.addEventListener("click", displayChoice(optionsHard[2]));
}

function clickMoviesOption() {

    reloadMovies();

    const movies0 = document.getElementById("movies0");
    const movies1 = document.getElementById("movies1");
    const movies2 = document.getElementById("movies2");

    movies0.addEventListener("click", displayChoice(optionsMovies[0]));
    movies1.addEventListener("click", displayChoice(optionsMovies[1]));
    movies2.addEventListener("click", displayChoice(optionsMovies[2]));

    var myModalEl = document.getElementById('moviesButMod')
    myModalEl.addEventListener('hidden.bs.modal', function (event) {displayReloadMovies()});

    //
    //let closeMovie = document.getElementById("closeMovieBut");
    //closeMovie.addEventListener("click", console.log("CLOOOOSE"));
    //


    //closeMovieModal ();
    //await getMovies();
    //changeMovies();
}

function nextPersonTurn() {
    nextTurn();
    document.body.scrollTop = 1000;
    console.log("nectTurn invoked");
}

function letsPlay() {
    startGame();
    //var canvas = document.getElementById('drawingcanvas');
    //var heightRatio = 0.75;
    //canvas.height = canvas.width * heightRatio;
}

function clearCanvas() {
    const canvas = document.getElementById("drawingcanvas");
    const context = canvas.getContext("2d");
    context.clearRect(0,0, canvas.width, canvas.height);
}

*/