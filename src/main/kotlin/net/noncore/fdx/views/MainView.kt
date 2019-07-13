package net.noncore.fdx.views

import javafx.scene.layout.AnchorPane
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import tornadofx.*

class MainView : View() {
    override val root: AnchorPane by fxml("/MainView.fxml")
    private val layout: BorderPane by fxid("layout")
    private val header: VBox by fxid("header")
    private val systemInfoView = SystemInfoView()
    private val storageInfoView = StorageInfoView()
    private val entityInfoView = EntityInfoView()
    private val entityListView = EntityListView()
    val model: MainViewModel = MainViewModel()

    init {
        header.children.addAll(
            systemInfoView.root,
            storageInfoView.root,
            entityInfoView.root
        )
        layout.center = entityListView.root
    }
}

class MainViewModel {
}
