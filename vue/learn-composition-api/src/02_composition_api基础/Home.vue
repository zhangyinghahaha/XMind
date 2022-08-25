<template>
    <div>
        {{ message }}
    </div>
</template>

<script>
    export default {
        props: {
            message: {
                type: String,
                required: true
            },
        },
        setup(props, context) {
            // setup里面不能使用this
            console.log(props.message);
            console.log(context.attrs);
            console.log(context.emit);
        }
    }
</script>

<style lang="scss" scoped>

</style>