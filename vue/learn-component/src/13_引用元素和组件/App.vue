<template>
    <div>
        <!-- 绑定一个元素 -->
        <h2 ref="title">哈哈哈</h2>
        <!-- 绑定一个组件 -->
        <NavBar ref="navBar"></NavBar>
        <button @click="btnClick">获取元素</button>
    </div>
</template>

<script>
import NavBar from "./NavBar.vue";
export default {
    name: 'app',
    methods: {
        btnClick() {
            let h2Element = this.$refs.title;
            let navBarCmp = this.$refs.navBar;
            console.log(h2Element);
            console.log(navBarCmp);
            console.log(navBarCmp.message);
        },
    },
    components: { NavBar },
};
</script>

<style lang="scss" scoped></style>
