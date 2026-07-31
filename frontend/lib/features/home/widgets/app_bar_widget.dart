import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:remixicon/remixicon.dart';

// implements PreferredSizeWidget

class AppBarWidget extends StatelessWidget {
  final String imageUrl;
  final String userName;
  const AppBarWidget({
    super.key,
    required this.imageUrl,
    required this.userName,
  });

  // @override
  // Size get preferredSize => const Size.fromHeight(kToolbarHeight);

  @override
  Widget build(BuildContext context) {
    return AppBar(
      backgroundColor: Colors.white,
      leading: Padding(
        padding: const EdgeInsets.only(left: 10),
        child: Container(
          width: 100,
          height: 100,
          decoration: BoxDecoration(
            color: Colors.grey,
            shape: BoxShape.circle,
            image: DecorationImage(image: CachedNetworkImageProvider(imageUrl)),
          ),
        ),
      ),
      title: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(
            "Welcome, $userName",
            style: GoogleFonts.dmSans(
              fontSize: 22,
              fontWeight: FontWeight.bold,
            ),
          ),
          Row(
            children: [
              Icon(RemixIcons.map_pin_line, size: 16, color: Color(0xff4FD18B)),
              Text(
                "Where do you wanna go?",
                style: GoogleFonts.dmSans(
                  fontSize: 12,
                  color: Color(0xff64748B),
                ),
              ),
            ],
          ),
        ],
      ),
      actions: [
        Stack(
          children: [
            IconButton(onPressed: () {}, icon: FaIcon(FontAwesomeIcons.bell)),
            Positioned(
              right: 13,
              top: 10,
              child: Container(
                width: 10,
                height: 10,
                decoration: BoxDecoration(
                  color: Colors.red,
                  shape: BoxShape.circle,
                ),
              ),
            ),
          ],
        ),
      ],
    );
  }
}
