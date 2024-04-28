import Login from "../page/Login.vue";
import Index from "../page/Index.vue";
import HelloWorld from "../components/HelloWorld.vue";

const routes = [
    {
        path: '/',
        component: Index
    },
    {
        path: '/hello',
        component: HelloWorld
    },
    {
        path: '/login',
        component: Login
    }
]

export default routes;