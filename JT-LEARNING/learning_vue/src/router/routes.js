import Login from "../page/Login.vue";
import Index from "../page/Index.vue";
import HelloWorld from "../components/HelloWorld.vue";
import Study1 from "../page/Study1.vue";
import Study2 from "../page/Study2.vue";
import Test from "../page/test.vue";
import Study3 from "../page/Study3.vue";

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
    },
    {
        path: '/study/2',
        component: Study2
    },
    {
        path: '/study/3',
        component: Study3
    },
    {
        path: '/test/1',
        component: Test
    }
]

export default routes;