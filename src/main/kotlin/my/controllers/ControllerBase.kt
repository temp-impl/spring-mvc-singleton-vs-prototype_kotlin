package my.controllers

import my.beans.PrototypeBean
import my.beans.SingletonBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.AutowireCapableBeanFactory
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

abstract class ControllerBase {

    @Autowired
    lateinit private var singleton: SingletonBean

    @Autowired
    lateinit private var prototype: PrototypeBean

    @Autowired
    lateinit private var factory: AutowireCapableBeanFactory

    private inline fun <reified T : Any> createAutowiredObject() : T =
        factory.createBean(T::class.java)

    @Suppress("unused")
    @RequestMapping("", "/")
    fun _default(model: Model): String {
        var map = mapOf(
            "controller" to  this,
            "singleton_member" to singleton,
            "prototype_member" to prototype,
            "singleton_created" to createAutowiredObject<SingletonBean>(),
            "prototype_created" to createAutowiredObject<PrototypeBean>()
        )
        model.addAttribute("map", map)
        return "default"
    }
}
