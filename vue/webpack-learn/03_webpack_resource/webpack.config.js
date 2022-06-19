const path = require('path');

module.exports = {
    entry: './src/main.js',
    output: {
        path: path.resolve(__dirname, './build'),
        filename: 'bundle.js',
    },
    module: {
        rules: [
            {
                test: /\.css$/,
                // loader: 'css-loader'
                use: [
                    'style-loader',
                    'css-loader', 
                    {
                        loader: 'postcss-loader',
                        options: {
                            postcssOptions: {
                                plugins: [require('postcss-preset-env')]
                            }
                        }
                    }
                ]
            },
            {
                test: /\.less$/,
                // loader: 'css-loader'
                use: [
                    'style-loader',
                    'css-loader', 
                    'less-loader',
                ]
            },
            {
                test: /\.(jpg|jpeg|png|gif|svg)$/i,
                use: 'file-loader',
            }
        ],
    }
}