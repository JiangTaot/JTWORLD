import HelloWorld from "../components/HelloWorld.vue";
import App from "../App.vue";
import Login from "../page/Login.vue";
import Index from "../page/Index.vue";

const routes = [
    {
        path: '/hello',
        component: Index
    },
    {
        path: '/login',
        component: Login
    }
]

export default routes;