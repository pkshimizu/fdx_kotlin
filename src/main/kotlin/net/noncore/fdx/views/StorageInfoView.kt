package net.noncore.fdx.views

import javafx.scene.layout.HBox
import tornadofx.*

class StorageInfoView : View() {
    override val root: HBox by fxml("/StorageInfoView.fxml")
    val model = StorageInfoViewModel()
}

class StorageInfoViewModel {
}
