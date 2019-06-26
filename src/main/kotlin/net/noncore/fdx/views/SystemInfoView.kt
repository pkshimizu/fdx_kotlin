package net.noncore.fdx.views

import javafx.scene.layout.HBox
import tornadofx.*

class SystemInfoView : View() {
    override val root: HBox by fxml("/SystemInfoView.fxml")
    val model: SystemInfoViewModel = SystemInfoViewModel()
}

class SystemInfoViewModel {
}