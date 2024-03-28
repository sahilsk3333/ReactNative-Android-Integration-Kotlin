import React, { useEffect } from 'react';
import { AppRegistry, StyleSheet, Text, View, Button, NativeEventEmitter, NativeModules } from 'react-native';

const HelloWorld = () => {
    useEffect(() => {
        const eventEmitter = new NativeEventEmitter();
        const subscription = eventEmitter.addListener('EventDataFromNative', (data) => {
            console.log('Received data from native:', data.message);
            sendDataToNative(`Response from React Native : ${data.message}`);
        });

        return () => {
            subscription.remove();
        };
    }, []);

    const sendDataToNative = (response) => {
        NativeModules.MyCustomModule.handleResponse(response);
    };

    const handleButtonClick = () => {
      NativeModules.MyCustomModule.handleButtonClick('Btn clicked from React Native');
    };

    return (
        <View style={styles.container}>
            <Text style={styles.hello}>Hello, World</Text>
            <Button title="Click Me" onPress={handleButtonClick} />
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
    },
    hello: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10,
    },
});

AppRegistry.registerComponent('MyReactNativeApp', () => HelloWorld);
