<template>
    <div>
        <NavBar>
            <template v-slot:left>
                <button>左按钮</button>
            </template>

            <template #center>
                <h2>我是标题</h2>
            </template>
            
            <template #right>
                <button>右按钮</button>
            </template>
        </NavBar>

        <p></p>

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