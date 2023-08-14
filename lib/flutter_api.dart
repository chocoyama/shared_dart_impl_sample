// import 'package:flutter/services.dart';
// import 'package:flutter/widgets.dart';
import 'package:shared_dart_impl_sample/pigeon/schema.g.dart';

// class FlutterAPI {
//   void configure() {
//     WidgetsFlutterBinding.ensureInitialized();

//     const methodChannel = MethodChannel("dart_channel");
//     methodChannel.setMethodCallHandler((call) async {
//       switch (call.method) {
//         case 'ping':
//           return 'pong';
//         default:
//           return null;
//       }
//     });
//   }
// }

class FlutterAPIImpl extends FlutterAPI {
  @override
  String ping() {
    return 'pong';
  }
}
