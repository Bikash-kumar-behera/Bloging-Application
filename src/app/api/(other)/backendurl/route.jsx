import { NextRequest, NextResponse } from "next/server";
export async function GET(request) {
        const url = process.env.BACKEND_URL

        return NextResponse.json({
            message: "BackEnd Url Featch successful",
            data: url,
        });
}
