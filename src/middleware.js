import { NextResponse } from "next/server";
import { jwtVerify } from "jose";

async function isTokenVerified(token) {
    try {
        const secret = new TextEncoder().encode(process.env.TOKEN_SECRET);
        const decoded = await jwtVerify(token, secret, {
            issuer: "urn:blogPost:issuer",
            audience: "urn:user:audience",
        });
        return !!decoded; // Check if token is valid and not expired
    } catch (error) {
        console.error("Error verifying token:", error);
        return false;
    }
}

// Your middleware function
export async function middleware(request) {
    const path = request.nextUrl.pathname;
    const isPublicPath =
        path === "/login" ||
        path === "/signup" ||
        path === "/verifyemail" ||
        path === "/forgotpassword";
    const token = request.cookies.get("token")?.value || "";

    if (isPublicPath && token && (await isTokenVerified(token))) {
        return NextResponse.redirect(new URL("/", request.nextUrl));
    }
    if (!isPublicPath && (!token || !(await isTokenVerified(token)))) {
        return NextResponse.redirect(new URL("/login", request.nextUrl));
    }
}

// See "Matching Paths" below to learn more
export const config = {
    matcher: [
        "/profile/:path*",
        "/login",
        "/signup",
        "/verifyemail",
        "/forgotpassword",
        "/resetpassword",
        "/search/:path*",
        "/api/favorites/:path*",
        "/",
    ],
};
