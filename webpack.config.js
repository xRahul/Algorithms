var path = require('path')
var MiniCssExtractPlugin = require('mini-css-extract-plugin')
// var HtmlWebpackPlugin = require('html-webpack-plugin')
var CleanWebpackPlugin = require('clean-webpack-plugin')

module.exports = {
  entry: './src/main/js/app.js',
  devtool: 'sourcemaps',
  cache: true,
  mode: 'development',
  output: {
    path: path.resolve(__dirname, 'src/main/resources/static/built'),
    filename: 'bundle.js'
  },
  module: {
    rules: [
      {
        test: path.join(__dirname, '.'),
        exclude: /(node_modules)/,
        use: [{
          loader: 'babel-loader',
          options: {
            presets: ['@babel/preset-env', '@babel/preset-react']
          }
        }]
      },
      {
        test: /\.scss$/,
        use: [
          'style-loader',
          MiniCssExtractPlugin.loader,
          'css-loader',
          'postcss-loader',
          'sass-loader'
        ]
      }
    ]
  },
  plugins: [
    new CleanWebpackPlugin('dist', {}),
    new MiniCssExtractPlugin({
      filename: 'style.css'
    })
  ]
}
