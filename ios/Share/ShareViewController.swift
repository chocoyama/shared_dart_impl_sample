//
//  ShareViewController.swift
//  Share
//
//  Created by Takuya Yokoyama on 2023/08/10.
//

import UIKit
import Social
import Flutter

class ShareViewController: SLComposeServiceViewController {

    override func isContentValid() -> Bool {
        true
    }

    override func didSelectPost() {
        Task {
            let flutterChannel = FlutterChannel()
            let result = await flutterChannel.ping()
//            let result = await flutterChannel.invokeMethod("ping", arguments: nil)
            print("### ", result)
        }
        self.extensionContext!.completeRequest(returningItems: [], completionHandler: nil)
    }

    override func configurationItems() -> [Any]! {
        []
    }

}
