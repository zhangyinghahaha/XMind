<template>
    <div>
        <h2>APP</h2>
        <!-- <Home message="hahaha" id="home"></Home> -->
        <Test></Test>
    </div>
</template>

<script>
import Home from "./Home.vue";
import Test from "./02_setup的返回值.vue"
export default {
    components: {
        Home,
        Test
    },
    setup() {},
};
</script>

<style lang="scss" scoped></style>
