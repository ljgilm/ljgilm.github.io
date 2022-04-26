const GameScreen = () => (
    `<div id="game" style="display:none">
        <div class="font1 row d-flex justify-content-center">
            See No Evil!
        </div>

        <input type="button" id="nextTurnBut"
                style="display:none; background-color: transparent; border-color: transparent;" value="Next Turn"
                class="font3">

        <span class="font5" id="timer"></span>

        <p align = "center">
            <canvas id="drawingcanvas" width="510" height="510" class="img-responsive"
                style="border: 1px solid black; background-color: white; justify-content: center;"></canvas>
        </p>


        <span class="column d-flex justify-content-center">
    
            <span id="options">
           
                <input type="button" id="easyBut" data-bs-toggle="modal" data-bs-target="#easyButMod"
                    style="display:inline; background-color: transparent; border-color: transparent;" value=" Easy "
                    class="font3">
    
                <input type="button" id="mediumBut" data-bs-toggle="modal" data-bs-target="#mediumButMod"
                    style="display:inline; background-color: transparent; border-color: transparent;" value=" Medium "
                    class="font3">
    
                <input type="button" id="hardBut" data-bs-toggle="modal" data-bs-target="#hardButMod"
                    style="display:inline; background-color: transparent; border-color: transparent;" value=" Hard "
                    class="font3">
    
                <input type="button" id="moviesBut" data-bs-toggle="modal" data-bs-target="#moviesButMod"
                    style="display: inline; background-color: transparent; border-color: transparent;" value=" Movies "
                    class="font3">
    
            </span>
        </span>
    </div>`
)

export default GameScreen; 

    
