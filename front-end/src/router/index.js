import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../components/Home.vue'
import Welcome from '../components/Welcome.vue'
import Problem1 from '../components/problem/Problem1.vue'
import Problem2 from '../components/problem/Problem2.vue'
import Problem3 from '../components/problem/Problem3.vue'
import Problem4 from '../components/problem/Problem4.vue'
import Problem5 from '../components/problem/Problem5.vue'
import Problem6 from '../components/problem/Problem6.vue'
import Problem7 from '../components/problem/Problem7.vue'
import Problem8 from '../components/problem/Problem8.vue'
import Problem9 from '../components/problem/Problem9.vue'


Vue.use(VueRouter)

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

const routes = [
  { path: '/', redirect: '/welcome' },
  {
    path: '/home',
    component: Home,
    redirect: '/welcome',
    children: [
      { path: '/welcome', component: Welcome },
      { path: '/problem1', component: Problem1 },
      { path: '/problem2', component: Problem2 },
      { path: '/problem3', component: Problem3 },
      { path: '/problem4', component: Problem4 },
      { path: '/problem5', component: Problem5 },
      { path: '/problem6', component: Problem6 },
      { path: '/problem7', component: Problem7 },
      { path: '/problem8', component: Problem8 },
      { path: '/problem9', component: Problem9 }
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
