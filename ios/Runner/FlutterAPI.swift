//
//  FlutterChannel.swift
//  Runner
//
//  Created by Takuya Yokoyama on 2023/08/10.
//

import Foundation
import Flutter

final class FlutterChannel {
    private let flutterEngine = FlutterEngine(name: "my flutter engine")
    private let api: FlutterAPI
    
    init() {
        flutterEngine.run(withEntrypoint: "nativeMain")
        api = FlutterAPI(binaryMessenger: flutterEngine.binaryMessenger)
    }
    
    func ping() async -> String {
        await withCheckedContinuation {
            api.ping(completion: $0.resume(returning:))
        }
    }
}
