const HardModal = () => (
    `<div class="modal fade" id="hardButMod" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
    aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered font4">
            <div class="modal-content" style="background-color: #5e4a4a">
                <div class="modal-header">
                    <h5 class="modal-title" id="staticBackdropLabel">Pick One Hard Option</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div id="hardButModBody" class="modal-body">
                    <button type="button" class="btn mb-2" data-bs-dismiss="modal" style="background-color: #d3b094">
                        <div id="hard0">
                        </div>
                    </button>
                    <button type="button" class="btn mb-2" data-bs-dismiss="modal" style="background-color: #d3b094">
                        <div id="hard1">
                        </div>
                    </button>
                    <button type="button" class="btn mb-2" data-bs-dismiss="modal" style="background-color: #d3b094">
                        <div id="hard2">
                        </div>
                    </button>
                </div>
            </div>
        </div>
    </div>
    `
)

export default HardModal;