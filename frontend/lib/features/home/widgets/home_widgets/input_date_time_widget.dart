import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class InputDateTimeWidget extends StatelessWidget {
  final TextEditingController? dateController;
  final IconData leading;
  final String title;
  final VoidCallback? trailing;
  final IconData? trailingIcon;

  const InputDateTimeWidget({
    super.key,
    this.dateController,
    required this.leading,
    required this.title,
    this.trailing,
    this.trailingIcon,
  });

  @override
  Widget build(BuildContext context) {
    return InkWell(
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
                      enabled: false,
                      controller: dateController,
                      readOnly:
                          true, // or enabled: false if you want it greyed out
                      decoration: const InputDecoration(
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
