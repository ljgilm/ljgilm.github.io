const StartMenu = () => (
    `<div id="startDiv" class="row d-flex justify-content-center m-5 mt-4 mb-4" style="display:block;">
        <div id="titleStart" class="font1">
            See No Evil!
        </div>
        <div class="row d-flex justify-content-center m-1 mb-3 mt-3">
            <img id="monkey" src="assets/monkeyLg.png"
                style="display:block; max-width: 400; height: auto; width: auto;">
        </div>
        <p class="font6">See No Evil is like pictionary. However, not only will you be timed, but as the time goes by your canvas will fade to black so draw quickly! Maybe keep track of what you are drawing too cause you might need to draw in the dark!</p>
        <input type="button" id="startBut"
            style="display:block; background-color: transparent; border-color: transparent;" value="START" class="font">
    </div>`);

export default StartMenu;