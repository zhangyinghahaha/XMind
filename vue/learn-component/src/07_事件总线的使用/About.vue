<template>
    <div>
        <button @click="btnClick">点我</button>
    </div>
</template>

<script>
import emmiter from "./utils/eventbus";
export default {
    methods: {
        btnClick() {
            console.log("about click");
            emmiter.emit('about');
        },
    },
};
</script>

<style lang="scss" scoped></style>
