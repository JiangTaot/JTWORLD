import Login from "../page/Login.vue";
import Index from "../page/Index.vue";
import HelloWorld from "../components/HelloWorld.vue";
import Study1 from "../page/Study1.vue";

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
    },
    {
        path: '/study/1',
        component: Study1
    }
]

export default routes;