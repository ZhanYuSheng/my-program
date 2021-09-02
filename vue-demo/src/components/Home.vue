<template>
    <div class="home">
        <img src="../assets/芝麻垮脸.jpg" height="200" width="200" >
        <div>邮箱地址: 1143109382@qq.com</div>
        <div>近期学习的 Demo 保存在github: <a href='https://github.com/ZhanYuSheng/my-program'>https://github.com/ZhanYuSheng/my-program</a></div>
        <router-link to="/updateLog">更新日志</router-link>
        <!-- 对应的组件内容渲染到router-view中 -->
        <router-view/>
    </div>
</template>

<style scoped>
    .home{
        text-align: center;
        margin-top: 60px;
    }
</style>