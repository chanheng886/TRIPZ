import 'package:flutter/material.dart';
import 'package:frontend/core/widgets/bottom_nav_bar.dart';
import 'package:frontend/features/auth/views/auth_screen.dart';
import 'package:frontend/features/booking/views/booking_screen.dart';
import 'package:frontend/features/contact/views/contact_screen.dart';
import 'package:frontend/features/home/views/home_screen.dart';
import 'package:frontend/features/shell/controllers/app_shell_controller.dart';
import 'package:get/get.dart';

class MainApp extends StatelessWidget {
  MainApp({super.key});

  final AppShellController controller = Get.put(AppShellController());

  final _screen = [
    HomeScreen(),
    BookingScreen(),
    ContactScreen(),
    AuthScreen(),
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Obx(
        () => IndexedStack(
          index: controller.currentIndex.value,
          children: _screen,
        ),
      ),
      bottomNavigationBar: Obx(
        () => BottomNavBar(
          currentIndex: controller.currentIndex.value,
          onTap: controller.changeTab,
        ),
      ),
    );
  }
}
