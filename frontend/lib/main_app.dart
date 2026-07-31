import 'package:flutter/material.dart';
import 'package:frontend/core/widgets/bottom_nav_bar.dart';
import 'package:frontend/features/auth/views/auth_screen.dart';
import 'package:frontend/features/booking/views/booking_screen.dart';
import 'package:frontend/features/contact/views/contact_screen.dart';
import 'package:frontend/features/home/views/home_screen.dart';
import 'package:frontend/features/shell/controllers/app_shell_controller.dart';
import 'package:get/get.dart';

class MainApp extends StatefulWidget {
  const MainApp({super.key});

  @override
  State<MainApp> createState() => _MainAppState();
}

class _MainAppState extends State<MainApp> {
  final AppShellController controller = Get.put(AppShellController());

  late TextEditingController fromWhereController;
  late TextEditingController toWhereController;
  late TextEditingController leavingDateController;

  @override
  void initState() {
    super.initState();
    fromWhereController = TextEditingController();
    toWhereController = TextEditingController();
    leavingDateController = TextEditingController();
  }

  @override
  void dispose() {
    fromWhereController.dispose();
    toWhereController.dispose();
    leavingDateController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final _screen = [
      HomeScreen(
        fromWhereController: fromWhereController,
        toWhereController: toWhereController,
        leavingDateController: leavingDateController,
      ),
      BookingScreen(),
      ContactScreen(),
      AuthScreen(),
    ];

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
