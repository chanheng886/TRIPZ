import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:google_fonts/google_fonts.dart';

class InputFieldWidget extends StatelessWidget {
  final TextEditingController? locationController;
  final IconData leading;
  final String title;
  final VoidCallback? trailing;
  final IconData? trailingIcon;
  final Widget? page;

  const InputFieldWidget({
    super.key,
    required this.leading,
    required this.title,
    this.locationController,
    this.trailing,
    this.trailingIcon,
    this.page,
  });

  @override
  Widget build(BuildContext context) {
    return InkWell(
      onTap: () {
        if (page != null) Get.to(() => page!);
      },
      child: Container(
        decoration: BoxDecoration(
          color: const Color(0xffF4F4F7),
          borderRadius: BorderRadius.circular(15),
        ),
        child: Padding(
          padding: const EdgeInsets.all(12),
          child: Row(
            children: [
              Icon(leading, size: 26),
              const SizedBox(width: 10),
              Expanded(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text(title, style: GoogleFonts.dmSans(fontSize: 16)),
                    TextField(
                      controller: locationController,
                      readOnly:
                          true, // or enabled: false if you want it greyed out
                      decoration: const InputDecoration(
                        enabled: false,
                        border: InputBorder.none,
                        hintText: 'Where?',
                        isDense: true,
                        hintStyle: TextStyle(fontSize: 14),
                        contentPadding: EdgeInsets.zero,
                      ),
                    ),
                  ],
                ),
              ),
              if (trailingIcon != null)
                CircleAvatar(
                  backgroundColor: Color(0xff4FD18B),
                  child: IconButton(
                    onPressed: trailing,
                    icon: Icon(trailingIcon, color: Colors.white),
                  ),
                ),
            ],
          ),
        ),
      ),
    );
  }
}
