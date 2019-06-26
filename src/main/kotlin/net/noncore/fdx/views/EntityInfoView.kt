package net.noncore.fdx.views

import javafx.scene.layout.HBox
import tornadofx.*

class EntityInfoView : View() {
    override val root: HBox by fxml("/EntityInfoView.fxml")
    val model = EntityInfoViewModel()
}

class EntityInfoViewModel {
}
