<template>
    <div>
        <!-- 编译作用域 -->
        <ChildCpn>
            <button>哈哈哈</button>
            <p>{{name}}</p>
        </ChildCpn>

        <ShowName :names="names">
            <template v-slot="slotProps">
                <button>{{slotProps.item}}</button>
            </template>
        </ShowName>
    </div>
</template>

<script>
import ChildCpn from "./ChildCpn.vue";
import ShowName from "./ShowName.vue";
export default {
    components: { ChildCpn, ShowName },
    data() {
        return {
            name: 'App.vue',
            names: ['a', 'b', 'c'],
        }
    },
};
</script>

<style lang="scss" scoped></style>
