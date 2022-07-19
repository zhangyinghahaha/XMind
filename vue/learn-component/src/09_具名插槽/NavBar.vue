<template>
    <div class="nav-bar">
        <div class="left">
            <slot name="left">左边</slot>
        </div>
        <div class="center">
            <slot name="center">中间</slot>
        </div>
        <div class="right">
            <slot name="right">右边</slot>
        </div>

        <div class="addition">
            <slot :name="name"></slot>
        </div>

        
    </div>
</template>

<script>
    export default {
        data() {
            return {
                name: 'zhang'
            }
        },
    }
</script>

<style scoped>
.nav-bar {
    display: flex;
}

.left, .right {
    width: 80px;
    height: 44px;
    background-color: red;
}

.center {
    flex: 1;
    height: 44px;
    background-color: blue;
}
</style>