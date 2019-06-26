package net.noncore.fdx.views

import javafx.scene.layout.AnchorPane
import tornadofx.*

class EntityListView : View() {
    override val root: AnchorPane by fxml("/EntityListView.fxml")
    val model = EntityListViewModel()
}

class EntityListViewModel {
}
