<template>
    <div>
        <NavBar>
            <template v-slot:left>
                <button>左按钮</button>
            </template>

            <template v-slot:center>
                <h2>我是标题</h2>
            </template>
            
            <template v-slot:right>
                <button>右按钮</button>
            </template>
        </NavBar>

        <NavBar></NavBar>
    </div>
</template>

<script>
import NavBar from './NavBar.vue';
    export default {
    components: { NavBar }
}
</script>

<style lang="scss" scoped>

</style>