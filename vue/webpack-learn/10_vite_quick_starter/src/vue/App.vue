<template>
    <div>
        <h2>{{message}}</h2>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                message: "hello app"
            }
        },
    }
</script>

<style scoped>
.h2 {
    color: burlywood;
}
</style>