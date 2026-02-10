// client/craco.config.js
module.exports = {
  webpack: {
    configure: (webpackConfig) => {
      // Disable source-map-loader for node_modules
      webpackConfig.module.rules = webpackConfig.module.rules.map((rule) => {
        if (rule.oneOf) {
          rule.oneOf = rule.oneOf.map((loader) => {
            if (
              loader.loader &&
              loader.loader.includes('source-map-loader') &&
              loader.exclude === undefined
            ) {
              loader.exclude = /node_modules/;
            }
            return loader;
          });
        }
        return rule;
      });
      return webpackConfig;
    },
  },
};
