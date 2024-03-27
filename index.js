import React from 'react';
import {AppRegistry, StyleSheet, Text, View,TextInput} from 'react-native';

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
});

const HelloWorld = () => {
  return (
    <View style={styles.container}>
      <Text style={styles.hello}>Hello, World</Text>
    </View>
  );
};


AppRegistry.registerComponent(
  'MyReactNativeApp',
  () => HelloWorld,
);