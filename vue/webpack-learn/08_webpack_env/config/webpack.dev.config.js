const { merge } = require('webpack-merge');
const path = require('path');

const commonConfig = require('./webpack.common.config');

module.exports = merge(commonConfig, {
    mode: 'development',
    // 建立js映射文件，方便开发调试
    devtool: 'source-map',
    devServer: {
        static: {
            directory: path.join(__dirname, './public')
        },
        hot: true,
        port: 3000,
        // 代理，解决跨域问题
        proxy: {
            '/mock': {
                target: 'https://fd82673c-ccc9-45d9-95b5-4a6105acd1c4.mock.pstmn.io',
                pathRewrite: { '^/mock': '' },
                secure: false,
                changeOrigin: true
            },
        }
    },
});