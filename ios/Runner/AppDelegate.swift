import UIKit
import Flutter

@UIApplicationMain
@objc class AppDelegate: FlutterAppDelegate {
    override func application(
        _ application: UIApplication,
        didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?
    ) -> Bool {
        GeneratedPluginRegistrant.register(with: self)
        Task { await doSomething() }
        return super.application(application, didFinishLaunchingWithOptions: launchOptions)
    }
    
    private func doSomething() async {
        let flutterChannel = FlutterChannel()
        let result = await flutterChannel.ping()
        print("### ", result)
    }
}

