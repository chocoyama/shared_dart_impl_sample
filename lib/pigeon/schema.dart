import 'package:pigeon/pigeon.dart';

@ConfigurePigeon(PigeonOptions(
  dartOut: 'lib/pigeon/schema.g.dart',
  kotlinOut: 'android/app/src/main/kotlin/com/example/shared_dart_impl_sample/Pigeon.kt',
  swiftOut: 'ios/Runner/Pigeon.swift',  
))

@HostApi()
abstract class HostAPI {
  String ping();
}

@FlutterApi()
abstract class FlutterAPI {
  String ping();
}